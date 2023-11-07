
"use client"
import { useState } from "react";
import Link from "next/link";
import './header2.scss'

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
          <li><Link href="/">Home</Link></li>
          <li><Link href="/cadastro">Cadastro</Link></li>
          <li><Link href="/planos">Planos</Link></li>
          <li><Link href="/cadastro-bike">Cadastro Bike</Link></li>
          <li><Link href="/contato">Contate - nos</Link></li>
        </ul>
      </div>
    </div>
  );
}
