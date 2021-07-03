public interface SortOptions {

    void execute();
    boolean check();
    float progress();
    long getTimeInSeconds();
    int getPassCount();
    int getCompareCount();
    int getArrayAccessCount();

}
