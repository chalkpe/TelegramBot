package pe.chalk.telegram.util;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-19
 */
public enum ParseMode {
    MARKDOWN("Markdown"), HTML("HTML");

    final String value;
    ParseMode(final String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return this.getValue();
    }
}
