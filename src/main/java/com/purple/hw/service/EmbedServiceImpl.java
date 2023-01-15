package com.purple.hw.service;

import com.purple.hw.connector.EmbedConnector;
import com.purple.hw.domain.Embed;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmbedServiceImpl implements EmbedService {

    private final EmbedConnector embedConnector;

    public EmbedServiceImpl(EmbedConnector embedConnector) {
        this.embedConnector = embedConnector;
    }

    @Override
    public Embed getEmbedInf(Embed embed) throws IOException {
        return embedConnector.callEmbedApi(embed);
    }
}
