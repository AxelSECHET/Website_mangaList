
package com.webmangalist.demowebmangalist.models;

import java.util.Map;

public class Manga{

    private String createdAt;
    private String updatedAt;
    private String slug;
    private String synopsis;
    private int coverImageTopOffset;
    private Map<String, String> titles;
    private String canonicalTitle;
    private String[] abbreviatedTitles;
    private String averageRating;
    private Map<Integer,String> ratingFrequencies;
    private Integer userCount;
    private Integer favoritesCount;
    private String startDate;
    private String endDate;
    private Integer popularityRank;
    private Integer ratingRank;
    private String ageRating;
    private String ageRatingGuide;
    private String subtype;
    private String status;
    private String tba;
    private Map<String, String> posterImage;
    private Map<String, String> coverImage;
    private Integer chapterCount;
    private Integer volumeCount;
    private String serialization;
    private String mangaType;

    public Manga() {
    }


    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getCoverImageTopOffset() {
        return this.coverImageTopOffset;
    }

    public void setCoverImageTopOffset(int coverImageTopOffset) {
        this.coverImageTopOffset = coverImageTopOffset;
    }

    public Map<String,String> getTitles() {
        return this.titles;
    }

    public void setTitles(Map<String,String> titles) {
        this.titles = titles;
    }

    public String getCanonicalTitle() {
        return this.canonicalTitle;
    }

    public void setCanonicalTitle(String canonicalTitle) {
        this.canonicalTitle = canonicalTitle;
    }

    public String[] getAbbreviatedTitles() {
        return this.abbreviatedTitles;
    }

    public void setAbbreviatedTitles(String[] abbreviatedTitles) {
        this.abbreviatedTitles = abbreviatedTitles;
    }

    public String getAverageRating() {
        return this.averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public Map<Integer,String> getRatingFrequencies() {
        return this.ratingFrequencies;
    }

    public void setRatingFrequencies(Map<Integer,String> ratingFrequencies) {
        this.ratingFrequencies = ratingFrequencies;
    }

    public Integer getUserCount() {
        return this.userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getFavoritesCount() {
        return this.favoritesCount;
    }

    public void setFavoritesCount(Integer favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getPopularityRank() {
        return this.popularityRank;
    }

    public void setPopularityRank(Integer popularityRank) {
        this.popularityRank = popularityRank;
    }

    public Integer getRatingRank() {
        return this.ratingRank;
    }

    public void setRatingRank(Integer ratingRank) {
        this.ratingRank = ratingRank;
    }

    public String getAgeRating() {
        return this.ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getAgeRatingGuide() {
        return this.ageRatingGuide;
    }

    public void setAgeRatingGuide(String ageRatingGuide) {
        this.ageRatingGuide = ageRatingGuide;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTba() {
        return this.tba;
    }

    public void setTba(String tba) {
        this.tba = tba;
    }

    public Map<String,String> getPosterImage() {
        return this.posterImage;
    }

    public void setPosterImage(Map<String,String> posterImage) {
        this.posterImage = posterImage;
    }

    public Map<String,String> getCoverImage() {
        return this.coverImage;
    }

    public void setCoverImage(Map<String,String> coverImage) {
        this.coverImage = coverImage;
    }

    public Integer getChapterCount() {
        return this.chapterCount;
    }

    public void setChapterCount(Integer chapterCount) {
        this.chapterCount = chapterCount;
    }

    public Integer getVolumeCount() {
        return this.volumeCount;
    }

    public void setVolumeCount(Integer volumeCount) {
        this.volumeCount = volumeCount;
    }

    public String getSerialization() {
        return this.serialization;
    }

    public void setSerialization(String serialization) {
        this.serialization = serialization;
    }

    public String getMangaType() {
        return this.mangaType;
    }

    public void setMangaType(String mangaType) {
        this.mangaType = mangaType;
    }

    @Override
    public String toString() {
        return "{" +
            " createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", slug='" + getSlug() + "'" +
            ", synopsis='" + getSynopsis() + "'" +
            ", coverImageTopOffset='" + getCoverImageTopOffset() + "'" +
            ", titles='" + getTitles() + "'" +
            ", canonicalTitle='" + getCanonicalTitle() + "'" +
            ", abbreviatedTitles='" + getAbbreviatedTitles() + "'" +
            ", averageRating='" + getAverageRating() + "'" +
            ", ratingFrequencies='" + getRatingFrequencies() + "'" +
            ", userCount='" + getUserCount() + "'" +
            ", favoritesCount='" + getFavoritesCount() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", popularityRank='" + getPopularityRank() + "'" +
            ", ratingRank='" + getRatingRank() + "'" +
            ", ageRating='" + getAgeRating() + "'" +
            ", ageRatingGuide='" + getAgeRatingGuide() + "'" +
            ", subtype='" + getSubtype() + "'" +
            ", status='" + getStatus() + "'" +
            ", tba='" + getTba() + "'" +
            ", posterImage='" + getPosterImage() + "'" +
            ", coverImage='" + getCoverImage() + "'" +
            ", chapterCount='" + getChapterCount() + "'" +
            ", volumeCount='" + getVolumeCount() + "'" +
            ", serialization='" + getSerialization() + "'" +
            ", mangaType='" + getMangaType() + "'" +
            "}";
    }
    
}