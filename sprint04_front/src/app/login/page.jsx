
"use client"
import { useEffect, useState } from 'react';
import './page.scss';


export default function Login() {
    const [cpf, setCpf] = useState('');
    
    function formataCPF(e) {
        const cpfValue = e.target.value;
        const formattedCPF = cpfValue.replace(
            /(\d{3})(\d{3})(\d{3})(\d{2})/,
            (match, part1, part2, part3, part4) => `${part1}.${part2}.${part3}-${part4}`
        );
        setCpf(formattedCPF);
    }

    return (
        <main>
            <section className="content">
                <h2>Login</h2>
                <form>

                    <div className="form">
                        <label htmlFor="cpf">CPF:</label>
                        <input
                            type="text"
                            name="cpf"
                            placeholder="Digite seu CPF"
                            pattern="\d{3}\.\d{3}\.\d{3}-\d{2}"
                            title="Digite um CPF no formato: xxx.xxx.xxx-xx"
                            value={cpf}
                            onChange={formataCPF}
                        />
                        <input type="submit" value="Verificar" required />
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
                    
                    <button>enviar</button>
                </form>
            </section>
        </main>
    );
}
