import axios from '../custom-axios/axios'

const libraryService = {

    fetchBooks: () => {
        return axios.get("/books");
    },

    fetchAuthors: () => {
        return axios.get("/authors");
    },

    fetchCategories: () => {
        return axios.get("/categories");
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },

    markBookAsRented: (id) => {
        return axios.put(`/books/rent/${id}`);
    },

    addBook: (name, category, author, availableCopies) => {
        return axios.post("/books/save", {
            "name": name,
            "category": category,
            "author": author,
            "availableCopies": availableCopies
        });
    },
    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name": name,
            "category": category,
            "author": author,
            "availableCopies": availableCopies
        });
    },

    getBook: (id) => {
        return axios.get(`/books/${id}`);
    }



}

export default libraryService;