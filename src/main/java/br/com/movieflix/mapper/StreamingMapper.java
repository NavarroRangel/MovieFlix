package br.com.movieflix.mapper;

import br.com.movieflix.controller.request.StreamingRequest;
import br.com.movieflix.controller.response.StreamingResponse;
import br.com.movieflix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest){
        Streaming streaming = new Streaming();
        streaming.setName(streamingRequest.name());
        return streaming;
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        StreamingResponse streamingResponse = new StreamingResponse(streaming.getId(), streaming.getName());
        return streamingResponse;

    }
}
