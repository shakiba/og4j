package me.shakiba.opengraph;

import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;

public class OpenGraphValue {

    private ArrayListMultimap<String, OpenGraphValue> values;
    private String value;

    public OpenGraphValue() {
    }

    public OpenGraphValue(String value) {
        this.value = value;
    }

    public OpenGraphValue(String name, String value) {
        add(name, value);
    }

    public boolean add(String name, String value) {
        if (value == null) {
            return false;
        }
        if (Strings.isNullOrEmpty(name)) {
            this.value = value;
            return true;
        }

        if (values == null) {
            synchronized (this) {
                if (values == null) {
                    values = ArrayListMultimap.create();
                }
            }
        }

        String[] names = name.split("\\:", 2);

        if (names.length == 1) {
            this.values.put(names[0], new OpenGraphValue(value));
            return true;
        }

        List<OpenGraphValue> values = this.values.get(names[0]);
        if (!is(values)) {
            this.values.put(names[0], new OpenGraphValue(names[1], value));
        } else {
            get(values, -1, null).add(names[1], value);
        }
        return true;
    }

    public String str() {
        return Strings.nullToEmpty(this.value);
    }

    public String str(String name, int... i) {
        return get(name, i).str();
    }

    private OpenGraphValue get(String name, int... i0) {
        if (name.contains(":")) {
            String[] names = name.split("\\:");
            int[] i;
            if (i0.length < names.length) {
                i = new int[names.length];
                System.arraycopy(i0, 0, i, 0, i0.length);
            } else {
                i = i0;
            }
            OpenGraphValue next = this;
            for (int j = 0; j < names.length; j++) {
                String nextName = names[j];
                next = next.get(nextName, i[j]);
            }
            return next;
        } else {
            return get(name, i0[0]);
        }
    }

    private OpenGraphValue get(String name, int i) {
        return values == null ? INVALID : get(values.get(name), i, INVALID);
    }

    @Override
    public String toString() {
        if (value == null) {
            return values + "";
        }
        if (values == null) {
            return "'" + value + "'";
        }
        return "'" + value + "', " + values;
    }

    public boolean isValid() {
        return true;
    }

    public static final OpenGraphValue INVALID = new OpenGraphValue() {
        @Override
        public boolean isValid() {
            return false;
        }
    };

    public static <E> E get(List<E> list, int i, E noValue) {
        int size = list.size();
        if (i < -size || size <= i) {
            return noValue;
        }
        return list.get(i < 0 ? list.size() - i : i);
    }

    public static boolean is(List<?> list) {
        return list != null && !list.isEmpty();
    }

}
