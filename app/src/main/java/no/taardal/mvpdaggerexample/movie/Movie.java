package no.taardal.mvpdaggerexample.movie;

public class Movie {

    private String title;
    private String imdbId;
    private String tagline;
    private String overview;
    private String language;
    private String edition;
    private int runtime;
    private String posterPath;
    private String backdropPath;

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", tagline='" + tagline + '\'' +
                ", overview='" + overview + '\'' +
                ", language='" + language + '\'' +
                ", edition='" + edition + '\'' +
                ", runtime=" + runtime +
                ", posterPath='" + posterPath + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && getClass() == object.getClass()) {
            Movie movie = (Movie) object;
            return (title == null && movie.getTitle() == null) || title.equals(movie.getTitle())
                    && (imdbId == null && movie.getImdbId() == null) || imdbId.equals(movie.getImdbId())
                    && (tagline == null && movie.getTagline() == null) || tagline.equals(movie.getTagline())
                    && (overview == null && movie.getOverview() == null) || overview.equals(movie.getOverview())
                    && runtime == movie.getRuntime()
                    && (posterPath == null && movie.getPosterPath() == null) || posterPath.equals(movie.getPosterPath())
                    && (backdropPath == null && movie.getBackdropPath() == null) || backdropPath.equals(movie.getBackdropPath());
        } else {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
}
