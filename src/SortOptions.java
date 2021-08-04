public interface SortOptions {

    void execute();
    void progress();
    boolean check();
    long getTimeInSeconds();
    long getPassCount();
    long getCompareCount();
    long getArrayAccessCount();

}
