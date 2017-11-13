package org.got.travel.gateway.castle.restapi;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.got.travel.castle.model.Castle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author macalak@itexperts.sk
 *
 */

@RestController
@RequestMapping("/gateway")
class CastleApiGateway {
    final Logger LOG = LoggerFactory.getLogger(CastleApiGateway.class);

    private final ReservationReader reservationReader;


    @Autowired
    public CastleApiGateway(ReservationReader reservationReader) {
        this.reservationReader = reservationReader;
    }

    public List<Castle> fallback() {
        return new ArrayList<Castle>();
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(method = RequestMethod.GET, value = "/castles")
    public List<Castle> castles() {
        LOG.info("Retrieving castles ...");
        return this.reservationReader.read();
    }
}

@FeignClient("castleservice")
interface ReservationReader {
    @RequestMapping(method = RequestMethod.GET, value = "/castles")
    List<Castle> read();
}

