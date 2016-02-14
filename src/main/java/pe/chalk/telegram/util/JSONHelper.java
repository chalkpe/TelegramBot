package pe.chalk.telegram.util;

import org.json.JSONArray;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class JSONHelper {
    private JSONHelper(){}

    public static <T> Stream<T> buildStream(final JSONArray array, Class<? extends T> typeClass){
        if(array == null) return Stream.empty();

        final Stream.Builder<T> builder = Stream.builder();
        for(int i = 0; i < array.length(); i++){
            if(array.isNull(i)) continue;

            final Object item = array.get(i);
            if(typeClass.isInstance(item)) builder.add(typeClass.cast(item));
        }
        return builder.build();
    }

    public static <T> List<T> asList(final JSONArray array, Class<? extends T> typeClass){
        return JSONHelper.buildStream(array, typeClass).collect(Collectors.toList());
    }
}
