package com.purple.hw.Embed;

import com.purple.hw.Connector.EmbedConnector;
import com.purple.hw.domain.Embed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmbedServiceTest {
    @Autowired
    EmbedConnector embedConnector;

    @Test
    void 유투브() {
        Embed embed = new Embed();
        embed.setUrl("https://www.youtube.com/watch?v=dBD54EZIrZo");
        embedConnector.callEmbedApi(embed);
    }
}
