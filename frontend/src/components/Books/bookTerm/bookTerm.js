import React from "react";
import {Link} from "react-router-dom";

const BookTerm = (props) => {

    return (

        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.author.name} {props.term.author.surname}</td>
            <td>{props.term.category}</td>
            <td>{props.term.availableCopies}</td>
            <td>

                <Link className={"btn btn-danger"}
                   onClick={() => props.onEdit(props.term.id)} to={`/books/edit/${props.term.id}`}
                >Edit</Link>

                <a style={{marginLeft: 5}} title={"Delete"} className={"btn btn-danger"}
                    onClick={() => props.onDelete(props.term.id)}
                >Delete</a>

                <a style={{marginLeft: 5}} title={"Mark as Taken"} className={"btn btn-danger"}
                   onClick={() => props.onRent(props.term.id)}
                >Mark as Taken</a>
            </td>
        </tr>

    );
}

export default BookTerm;

