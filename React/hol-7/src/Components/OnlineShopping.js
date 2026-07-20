import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {
  render() {
    const items = [
      { id: 1, Itemname: "Laptop", Price: "Rs 55000" },
      { id: 2, Itemname: "Mobile Phone", Price: "Rs 15000" },
      { id: 3, Itemname: "Headphones", Price: "Rs 2500" },
      { id: 4, Itemname: "Keyboard", Price: "Rs 1200" },
      { id: 5, Itemname: "Mouse", Price: "Rs 800" }
    ];

    return (
      <div style={{ padding: "20px", fontFamily: "sans-serif" }}>
        <h1 style={{ color: "Brown" }}>Working with Props</h1>
        <h2>Online Shopping</h2>
        <table style={{ width: "50%", borderCollapse: "collapse", margin: "20px 0" }}>
          <thead>
            <tr style={{ backgroundColor: "#f2f2f2" }}>
              <th style={{ border: "1px solid #ddd", padding: "10px", textAlign: "left" }}>Item Name</th>
              <th style={{ border: "1px solid #ddd", padding: "10px", textAlign: "left" }}>Price</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item) => (
              <Cart key={item.id} Itemname={item.Itemname} Price={item.Price} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
