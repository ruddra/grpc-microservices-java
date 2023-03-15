package com.grpcflix.aggregator.service;

import com.grpcflix.aggregator.dto.RecommendedMovie;
import com.grpcflix.aggregator.dto.UserGenre;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.example.grpcflix.movie.Genre;
import org.example.grpcflix.movie.MovieSearchRequest;
import org.example.grpcflix.movie.MovieSearchResponse;
import org.example.grpcflix.movie.MovieServiceGrpc;
import org.example.grpcflix.user.UserGenreUpdateRequest;
import org.example.grpcflix.user.UserResponse;
import org.example.grpcflix.user.UserSearchRequest;
import org.example.grpcflix.user.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMovieService {
    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userStub;

    @GrpcClient("movie-service")
    private MovieServiceGrpc.MovieServiceBlockingStub movieStub;

    public List<RecommendedMovie> getUserMovieSuggestions(String loginId) throws SSLException {
        UserSearchRequest userSearchRequest = UserSearchRequest.newBuilder().setLoginId(loginId).build();
//        System.out.println(userStub.toString());
        UserResponse userResponse = userStub.getUserGenre(userSearchRequest);
        MovieSearchRequest movieSearchRequest = MovieSearchRequest.newBuilder().setGenre(userResponse.getGenre()).build();
        MovieSearchResponse movieSearchResponse = movieStub.getMovies(movieSearchRequest);
        return movieSearchResponse.getMovieList()
                .stream()
                .map(movieDto -> new RecommendedMovie(movieDto.getTitle(), movieDto.getYear(), movieDto.getRating()))
                .collect(Collectors.toList());
    }

    public void setUserGenreObject(UserGenre userGenre) throws SSLException {
        UserGenreUpdateRequest userGenreUpdateRequest = UserGenreUpdateRequest.newBuilder()
                .setGenre(Genre.valueOf(userGenre.getGenre().toUpperCase()))
                .setLoginId(userGenre.getLoginId())
                .build();

        UserResponse userResponse = userStub.updateUserGenre(userGenreUpdateRequest);
    }
}
