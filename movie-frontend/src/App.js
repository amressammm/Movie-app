
import './App.css';
import {
  BrowserRouter,
  Route,
  Routes,
} from "react-router-dom";
import HomePage from './pages/HomePage';
import SearchPage from './pages/SearchPage';
import  MoviePage  from './pages/MoviePage';

function App() {
  return (
    <BrowserRouter>
    <div>
    <Routes>
    
    <Route path="/" element={<HomePage />} exact={true}></Route>
    <Route path="/searchPage" element={<SearchPage />} exact={true}></Route>
    <Route path="/moviePage" element={<MoviePage />} exact={true}></Route>

    </Routes>
    </div>
    </BrowserRouter>
   
  );
}

export default App;
