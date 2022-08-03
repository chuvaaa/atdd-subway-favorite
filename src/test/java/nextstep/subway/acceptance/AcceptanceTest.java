package nextstep.subway.acceptance;

import io.restassured.RestAssured;
import nextstep.DataLoader;
import nextstep.subway.utils.DatabaseCleanup;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static nextstep.subway.utils.AdministratorInfo.*;
import static nextstep.subway.acceptance.step.MemberSteps.로그인_되어_있음;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcceptanceTest {
    @LocalServerPort
    int port;

    @Autowired
    private DatabaseCleanup databaseCleanup;

    @Autowired
    private DataLoader dataLoader;

    public static String 관리자토큰;
    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        databaseCleanup.execute();
        dataLoader.loadData();
        관리자토큰 = 로그인_되어_있음(ADMIN_EMAIL, ADMIN_PASSWORD);

    }
}
