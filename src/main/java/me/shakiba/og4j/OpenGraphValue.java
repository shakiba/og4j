package me.shakiba.og4j;

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
        put(name, value);
    }

    public boolean put(String name, String value) {
        if (value == null) {
            return false;
        }
        if (Strings.isNullOrEmpty(name)) {
            this.value = value;
            return true;
        }

        values();
        
        String[] names = name.split("\\:", 2);

        if (names.length == 1) {
            this.values.put(names[0], new OpenGraphValue(value));
            return true;
        }

        List<OpenGraphValue> values = this.values.get(names[0]);
        if (!is(values)) {
            this.values.put(names[0], new OpenGraphValue(names[1], value));
        } else {
            get(values, -1, null).put(names[1], value);
        }
        return true;
    }

    private synchronized ArrayListMultimap<String, OpenGraphValue> values() {
        if (values == null) {
            values = ArrayListMultimap.create();
        }
        return values;
    }

    public String string() {
        return Strings.nullToEmpty(this.value);
    }

    public String string(String name, int... i) {
        return get(name, i).string();
    }

    public OpenGraphValue get(String name, int... index) {
        String[] names = name.split("\\:");

        OpenGraphValue value = this;

        for (int i = 0; i < names.length && i < index.length; i++) {
            String nextName = names[i];
            value = value.get(nextName, index[i]);
        }
        for (int i = index.length; i < names.length; i++) {
            String nextName = names[i];
            value = value.get(nextName, 0);
        }

        return value;
    }

    public OpenGraphValue get(String name, int i) {
        return values == null ? INVALID : get(values.get(name), i, INVALID);
    }

    public boolean isValid() {
        return true;
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

    public static final OpenGraphValue INVALID = new OpenGraphValue() {
        @Override
        public boolean isValid() {
            return false;
        }
    };

    private static <E> E get(List<E> list, int i, E noValue) {
        int size = list.size();
        if (i < -size || size <= i) {
            return noValue;
        }
        return list.get(i < 0 ? list.size() + i : i);
    }

    private static boolean is(List<?> list) {
        return list != null && !list.isEmpty();
    }

}
