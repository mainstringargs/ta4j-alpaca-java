package io.github.mainstringargs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import io.github.mainstringargs.domain.polygon.websocket.PolygonStreamMessage;
import io.github.mainstringargs.polygon.PolygonAPI;
import io.github.mainstringargs.polygon.websocket.listener.PolygonStreamListener;
import io.github.mainstringargs.polygon.websocket.message.PolygonStreamMessageType;

public class Ta4jTest {

    public static void main(String[] args) {

        PolygonAPI polygonApi = new PolygonAPI();

        polygonApi.addPolygonStreamListener(new PolygonStreamListener() {

            @Override
            public void onStreamUpdate(PolygonStreamMessageType streamMessageType,
                            PolygonStreamMessage streamMessage) {
                System.out.println(streamMessageType + " " + streamMessage);

            }

            @Override
            public Map<String, Set<PolygonStreamMessageType>> getStockChannels() {
                return new HashMap<String, Set<PolygonStreamMessageType>>() {
                    {
                        put("TNA", new HashSet<PolygonStreamMessageType>(Arrays.asList(PolygonStreamMessageType.TRADE)));
                        put("UDOW", new HashSet<PolygonStreamMessageType>(Arrays.asList(PolygonStreamMessageType.TRADE)));
                        put("TQQQ", new HashSet<PolygonStreamMessageType>(Arrays.asList(PolygonStreamMessageType.TRADE)));
                    }
                };
            }
        });

    }

}
