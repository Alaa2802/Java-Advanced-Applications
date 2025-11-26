public class Coordinate<T extends Number, U extends Number> {
    private T latitude;
    private U longitude;

    public Coordinate(T latitude, U longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public T getLatitude() {
        return latitude;
    }

    public U getLongitude() {
        return longitude;
    }

    // Enlem ve boylam kullanarak iki nokta arasındaki mesafeyi hesaplayan metot
    public double calculateDistance(Coordinate<T, U> other) {
        double lat1 = this.latitude.doubleValue();
        double lon1 = this.longitude.doubleValue();
        double lat2 = other.latitude.doubleValue();
        double lon2 = other.longitude.doubleValue();

        // Haversine formulü
        final int R = 6371; // Yarıçapı km cinsinden
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return distance;
    }
}
