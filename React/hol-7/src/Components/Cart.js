import React, { Component } from "react";

class Cart extends Component {
  render() {
    const { Itemname, Price } = this.props;
    return (
      <tr>
        <td style={{ border: "1px solid #ddd", padding: "10px" }}>{Itemname}</td>
        <td style={{ border: "1px solid #ddd", padding: "10px" }}>{Price}</td>
      </tr>
    );
  }
}

export default Cart;
