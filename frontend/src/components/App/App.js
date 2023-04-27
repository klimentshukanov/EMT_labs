import './App.css';
import React, {Component} from "react";
import Books from "../Books/bookList/books"
import Header from "../Header/header"
import Categories from "../Categories/categories"
import BookAdd from "../Books/bookAdd/bookAdd"

import libraryService from "../../repository/libraryRepository";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom/dist'
import libraryRepository from "../../repository/libraryRepository";
import BookEdit from "../Books/bookEdit/bookEdit";


class App extends Component
{

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: [],
            selectedBook: {}
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

                            <Route path={"/books/edit/:id"} exact
                                   element={<BookEdit categories={this.state.categories} authors={this.state.authors}
                                                     onEditBook={this.editBook} book={this.state.selectedBook}/>}/>

                            <Route path={"/books/add"} exact
                                   element={<BookAdd categories={this.state.categories} authors={this.state.authors}
                                                     onAddBook={this.addBook}/>}/>


                            <Route path={"/books"} exact
                                   element={<Books books={this.state.books} onDelete={this.deleteBook}
                                                   onRent={this.rentBook} onEdit={this.getBook}
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

    loadAuthors = () => {
        libraryService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
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

    addBook = (name, category, author, availableCopies) => {
        libraryService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    editBook = (id, name, category, author, availableCopies) => {
        libraryRepository.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        libraryService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }




    componentDidMount() {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }

}

export default App;
