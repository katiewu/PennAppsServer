package DBUtils;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DBUser {

	static DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
			new ProfileCredentialsProvider()));
	static String TableName = "User";

	public static void addUser(User user) {
		Table table = dynamoDB.getTable(TableName);

		Item item = new Item().withPrimaryKey("PhoneNumber", user.getPhonenumber())
				.withString("Username", user.getUsername())
				.withString("Password", user.getPassword())
				.withString("VenmoID", user.getVenmoid());
		table.putItem(item);
	}
	
	public static User getUser(String phonenumber) {
		Table table = dynamoDB.getTable(TableName);
		Item item = table.getItem("PhoneNumber", // attribute name
                phonenumber, // attribute value
                "PhoneNumber, Username, Password, VenmoID", // projection expression
                null); // name map - don't need this
		User user = new User();
		user.setPhonenumber(item.getString("PhoneNumber"));
		user.setUsername(item.getString("Username"));
		user.setPassword(item.getString("Password"));
		user.setVenmoid(item.getString("VenmoID"));
		return user;
	}

}
