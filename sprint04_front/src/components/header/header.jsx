"use client";
import { useState } from "react";
import Link from "next/link";
import "./header.scss";
//import './css2.scss'

export default function Header() {
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  const toggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  return (
    <div className='menu-container'>
      <img
        className="botao"
        src="menu.png"
        onClick={toggleMenu}
        width={48}
        alt="Menu"
      />
      <div className={`menu ${isMenuOpen ? 'open' : ''}`}>
        <ul>
          <li><a href="/">Home</a></li>
          <li><a href="/cadastro">Cadastro</a></li>
          <li><a href="/planos">Planos</a></li>
          <li><a href="/cadastro-bike">Cadastro Bike</a></li>
          <li><a href="/contato">Contate - nos</a></li>
        </ul>
      </div>
    </div>
  );
};
