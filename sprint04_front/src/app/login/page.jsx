
"use client"
import { useEffect, useState } from 'react';
import './page.scss';

export default function Login() {
    const [email, setEmail] = useState('');

    return (
        <main>
            <section className="content">
                <h2>Login</h2>
                <form>
                    <div className="form">
                        <label htmlFor="email">Email:</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            placeholder="Digite seu email"
                            required
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                    </div>

                    <div className="form">
                        <label htmlFor="senha">Senha:</label>
                        <input
                            type="password"
                            id="senha"
                            name="senha"
                            placeholder="Digite sua senha"
                            required
                        />
                    </div>

                    <button>Enviar</button>
                </form>
            </section>
        </main>
    );
}
