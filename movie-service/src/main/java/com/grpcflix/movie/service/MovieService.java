package com.grpcflix.movie.service;

import com.grpcflix.movie.repository.MovieRepository;
import org.example.grpcflix.movie.MovieDto;
import org.example.grpcflix.movie.MovieSearchRequest;
import org.example.grpcflix.movie.MovieSearchResponse;
import org.example.grpcflix.movie.MovieServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class MovieService extends MovieServiceGrpc.MovieServiceImplBase {
    @Autowired
    private MovieRepository repository;

    @Override
    public void getMovies(MovieSearchRequest request, StreamObserver<MovieSearchResponse> responseStreamObserver) {
        List<MovieDto> movieDtoList = this.repository.getMovieByGenreOrderByYearDesc(request.getGenre().toString())
                .stream()
                .map(movie -> MovieDto.newBuilder()
                        .setTitle(movie.getTitle())
                                .setYear(movie.getYear())
                                .setRating(movie.getRating())
                                .build())
                .collect(Collectors.toList());
        responseStreamObserver.onNext(MovieSearchResponse.newBuilder().addAllMovie(movieDtoList).build());
        responseStreamObserver.onCompleted();


    }
}
