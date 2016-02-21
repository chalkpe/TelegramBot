package pe.chalk.telegram.type.file.photo;

import org.json.JSONArray;
import org.json.JSONObject;
import pe.chalk.telegram.util.JSONHelper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class UserProfilePhotos {
    private final int totalCount;
    private final List<Photo> photos;

    private UserProfilePhotos(final JSONObject json){
        this.totalCount = json.getInt("total_count");
        this.photos     = JSONHelper.buildStream(json.getJSONArray("photos"), JSONArray.class).map(Photo::create).collect(Collectors.toList());
    }

    public static UserProfilePhotos create(final JSONObject json){
        return new UserProfilePhotos(json);
    }

    public int getTotalCount(){
        return this.totalCount;
    }

    public List<Photo> getPhotos(){
        return this.photos;
    }
}
