import React from "react";

const BookDetails = () => {
  const books = [
    { title: "React Basics", author: "Dan Abramov", price: "₹ 450" },
    { title: "Learning ES6", author: "Kyle Simpson", price: "₹ 380" },
    { title: "Node.js in Action", author: "Mike Cantelon", price: "₹ 520" }
  ];

  return (
    <div style={{ padding: "15px", border: "1px solid #0275d8", borderRadius: "5px", backgroundColor: "#f0f8ff" }}>
      <h3 style={{ color: "#0275d8", marginTop: 0 }}>Book Details</h3>
      <ul style={{ paddingLeft: "20px" }}>
        {books.map((book, idx) => (
          <li key={idx} style={{ margin: "8px 0" }}>
            <strong>{book.title}</strong> by {book.author} — <span style={{ color: "#292b2c" }}>{book.price}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookDetails;
