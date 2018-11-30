package works.weave.socks.orders.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import org.springframework.context.annotation.Configuration;

@Configuration

public class DynamoDBConfiguration {
    @Value(“${amazon.dynamodb.endpoint}”)
    private String amazonDynamoDBEndpoint;@Value(“${amazon.aws.accesskey}”)
    private String amazonAWSAccessKey;@Value(“${amazon.aws.secretkey}”)
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }
        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }

    public AmazonDynamoDBClient getClient() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials).withRegion(Regions.AP_SOUTHEAST_1);
        return client;
    }
}