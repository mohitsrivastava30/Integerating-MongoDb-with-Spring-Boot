package mongodbexample;

import mongodbexample.models.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class MongodbexampleApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testAddData() {

		Student student = new Student(2,"Virat","Bangalore","RCB");
		// Set your model data

		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/student/", student, String.class);

		assertEquals(HttpStatus.OK,
				response.getStatusCode());
		// Add more assertions if needed
	}

	@Test
	void contextLoads() {
	}

}
