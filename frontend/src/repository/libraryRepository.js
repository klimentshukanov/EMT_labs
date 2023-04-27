import axios from '../custom-axios/axios'

const libraryService = {

    fetchBooks: () => {
        return axios.get("/books");
    },

    fetchCategories: () => {
        return axios.get("/categories");
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    }

}

export default libraryService;