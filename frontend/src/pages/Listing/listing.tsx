import axios from "axios";
import MovieCard from "components/MovieCard/moviecard";
import Pagination from "components/Pagination/pagnation";
import { BASE_URL } from "ultils/requests";

function Listing(){

    axios.get(`${BASE_URL}/movies?size=12&page=0`)
    .then(response =>{
        console.log(response.data);
    });
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