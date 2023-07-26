import React, { Component } from "react";

const HomePage = () => {
  return (
    <div className="home-page">
      <h2 className="heading">Elige tu nivel</h2>
      <div className="button-container">
        <button className="btn-basic">Básico</button>
        <button className="btn-intermediate">Intermedio</button>
        <button className="btn-advanced">Avanzado</button>
      </div>
    </div>
  );
}

export default HomePage;