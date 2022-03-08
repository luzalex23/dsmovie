import MovieCard from "components/MovieCard/moviecard";
import Pagination from "components/Pagination/pagnation";

function Listing(){
    return(
        <>
            <Pagination />

            <div className="container">
                <div className="row">
                    <div className="col -sm -6">
                    <MovieCard />
                    </div>
                    <div className="col -sm -6">
                    <MovieCard />
                    </div>
                    <div className="col -sm -6">
                    <MovieCard />
                    </div>
                    <div className="col -sm -6">
                    <MovieCard />
                    </div>
                
                </div>
            </div>
       </>
    );

}
export default Listing;