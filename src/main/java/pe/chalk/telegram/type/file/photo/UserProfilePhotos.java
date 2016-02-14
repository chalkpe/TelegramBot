package pe.chalk.telegram.type.file.photo;

import java.util.List;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class UserProfilePhotos {
    private final int totalCount;
    private final List<Photo> photos;

    public UserProfilePhotos(final int totalCount, final List<Photo> photos){
        this.totalCount = totalCount;
        this.photos = photos;
    }

    public int getTotalCount(){
        return this.totalCount;
    }

    public List<Photo> getPhotos(){
        return this.photos;
    }
}
