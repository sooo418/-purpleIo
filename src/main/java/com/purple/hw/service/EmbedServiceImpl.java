package com.purple.hw.service;

import com.purple.hw.Connector.EmbedConnector;
import com.purple.hw.domain.Embed;
import org.springframework.stereotype.Service;

@Service
public class EmbedServiceImpl implements EmbedService {

    private final EmbedConnector embedConnector;

    public EmbedServiceImpl(EmbedConnector embedConnector) {
        this.embedConnector = embedConnector;
    }

    @Override
    public Embed getEmbedInf(Embed embed) {
        return embedConnector.callEmbedApi(embed);
    }
}
