package com.gorobchenkoa.model.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "buyDate")
    private Date buyDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "movieDate")
    private Date movieDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Date movieDate) {
        this.movieDate = movieDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Report report = (Report) o;

        if (buyDate != null ? !buyDate.equals(report.buyDate) : report.buyDate != null) return false;
        if (movieDate != null ? !movieDate.equals(report.movieDate) : report.movieDate != null) return false;
        return !(movie != null ? !movie.equals(report.movie) : report.movie != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (buyDate != null ? buyDate.hashCode() : 0);
        result = 31 * result + (movieDate != null ? movieDate.hashCode() : 0);
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        return result;
    }
}
