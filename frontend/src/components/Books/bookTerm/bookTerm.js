import React from "react";

const BookTerm = (props) => {

    return (

        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.author.name} {props.term.author.surname}</td>
            <td>{props.term.category}</td>
            <td>{props.term.availableCopies}</td>
            <td>
                <a title={"Delete"} className={"btn btn-danger"}
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

