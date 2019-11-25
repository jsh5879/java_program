public class TestSimpleTimeClient {
	public static void main(String... args) {
		TimeClient myTimeClient = new SimpleTimeClient();
		System.out.println("Current time: " + myTimeClient.toString());
		System.out.println("Time in Seoul: " +
				myTimeClient.getZonedDateTime("Asia/Seoul").toString());
	}
}