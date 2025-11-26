public class Triple<T extends Number, U extends Number, V extends Comparable<V>> {
    private Coordinate<T, U> coordinate;
    private V altitude;

    public Triple(Coordinate<T, U> coordinate, V altitude) {
        this.coordinate = coordinate;
        this.altitude = altitude;
    }

    public Coordinate<T, U> getCoordinate() {
        return coordinate;
    }

    public V getAltitude() {
        return altitude;
    }

    // Yükseklikleri karşılaştıran metot
    public int compareAltitude(Triple<T, U, V> other) {
        return this.altitude.compareTo(other.altitude);
    }
}
