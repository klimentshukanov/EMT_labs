import logo from '../../logo.svg';
import './App.css';
import React, {Component} from "react";
import Books from "../Books/bookList/books"
import Header from "../Header/header"
import Categories from "../Categories/categories"

import libraryService from "../../repository/libraryRepository";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom/dist'


class App extends Component
{

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: []
        }
    }

    render() {
        return(
            <Router>
                <main>
                    <div>
                    <Header/>

                    <div>
                        <Routes>

                            <Route path={"/"} exact
                                   element={<Books books={this.state.books} onDelete={this.deleteBook}
                                                   onRent={this.rentBook}
                                   />}/>

                            <Route path={"/categories"} exact
                                   element={<Categories categories={this.state.categories}/>}/>



                        </Routes>
                    </div>
                    </div>
                </main>

            </Router>
        );

    }

    loadBooks = () => {
        libraryService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    loadCategories = () => {
        libraryService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    deleteBook = (id) => {
        libraryService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    rentBook = (id) => {
        libraryService.markBookAsRented(id)
            .then(() => {
                this.loadBooks();
            });
    }


    componentDidMount() {
        this.loadBooks();
        this.loadCategories();
    }

}

export default App;
