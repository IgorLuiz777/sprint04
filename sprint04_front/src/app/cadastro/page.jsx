"use client"
import { useEffect, useState } from 'react';
import Link from 'next/link';
import './page.scss'

export default function Cadastro() {
    const [id, setId] = useState('');
    const [cpf, setCpf] = useState('');
    const [cep, setCep] = useState('');
    const [numero, setNumero] = useState('');
    const [logradouro, setLogradouro] = useState('');
    const [bairro, setBairro] = useState('');
    const [localidade, setLocalidade] = useState('');
    const [nome, setNome] = useState('');
    const [dataNascimento, setDataNascimento] = useState('');
    const [cepVerified, setCepVerified] = useState(false);
    const [senha, setSenha] = useState('');
    const [email, setEmail] = useState('');

    function formataCPF(e) {
        const cpfValue = e.target.value;
        const formattedCPF = cpfValue.replace(
            /(\d{3})(\d{3})(\d{3})(\d{2})/,
            (match, part1, part2, part3, part4) => `${part1}.${part2}.${part3}-${part4}`
        );
        setCpf(formattedCPF);
    }

    const handleCepChange = (e) => {
        const newCep = e.target.value;
        setCep(newCep);
        setCepVerified(false);
    }

    const handleNomeChange = (e) => {
        const newName = e.target.value;
        setNome(newName);
    }
    const handleNumeroChange = (e) => {
        const newNumero = e.target.value;
        setNumero(newNumero);
    }

    const handleDataNascimentoChange = (e) => {
        const newDataNascimento = e.target.value;
        setDataNascimento(newDataNascimento);
    }

    const handleSenhaChange = (e) => {
        const newSenha = e.target.value;
        setSenha(newSenha);
    }

    const handleEmailChange = (e) => {
        const newEmail = e.target.value;
        setEmail(newEmail);
    }

    const handleFormSubmit = (e) => {
        e.preventDefault();

        const novoCliente = {
            id: id,
            nome: nome,
            dataNascimento: dataNascimento,
            cpf: cpf,
            email: email,
            senha: senha,
            endereco: {
                logradouro: logradouro,
                bairro: bairro,
                cidade: localidade,
                cep: cep,
            }
        };

        if (numero) {
            novoCliente.endereco.numero = numero;
        }


        fetch('http://localhost:8080/WebApi/rest/clientes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(novoCliente),
        })
            .then(() => {
                console.log('Cliente criado com sucesso');
            })
            .catch(error => {
                console.error('Erro ao criar cliente', error);
            });
    }

    useEffect(() => {
        if (cep.length === 8) {
            fetch(`https://viacep.com.br/ws/${cep}/json/`)
                .then(response => response.json())
                .then(data => {
                    setLogradouro(data.logradouro);
                    setBairro(data.bairro);
                    setLocalidade(data.localidade);
                    setCepVerified(true);
                })
                .catch(error => {
                    console.error('Erro ao buscar dados do CEP', error);
                });
        }
    }, [cep]);

    return (
        <main>
            <section className="content">
                <h2>Insira os seus dados para criar seu cadastro: </h2>
                <form onSubmit={handleFormSubmit}>
                    <div className="form">
                        <label htmlFor="id">ID:</label>
                        <input
                            type="text"
                            id="id"
                            name="id"
                            placeholder="Digite o seu ID"
                            required
                            value={id}
                            onChange={(e) => setId(e.target.value)}
                        />
                    </div>

                    <div className="form">
                        <label htmlFor="nome">Nome:</label>
                        <input
                            type="text"
                            id="nome"
                            name="nome"
                            placeholder="Digite seu nome"
                            required
                            value={nome}
                            onChange={handleNomeChange}
                        />
                    </div>

                    <div className="form">
                        <label htmlFor="data_nasc">Data de nascimento:</label>
                        <input
                            type="date"
                            id="data_nasc"
                            name="data_nasc"
                            placeholder="Digite sua data de nascimento"
                            required
                            value={dataNascimento}
                            onChange={handleDataNascimentoChange}
                        />
                    </div>

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
                            value={senha}
                            onChange={handleSenhaChange}
                        />
                    </div>

                    <div className="form">
                        <label htmlFor="email">E-mail:</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            placeholder="Digite seu email"
                            required
                            value={email}
                            onChange={handleEmailChange}
                        />
                    </div>

                    <div className="form">
                        <label htmlFor="cep">CEP:</label>
                        <input
                            type="text"
                            name="cep"
                            placeholder="Digite seu CEP"
                            pattern="\d{5}\d{3}"
                            title="Digite o CEP no formato: xxxxxxxx"
                            value={cep}
                            onChange={handleCepChange}
                        />
                        <input type="submit" value="Verificar" required />
                    </div>

                    {cepVerified && (
                        <div>
                            <div className="form">
                                <label htmlFor="logradouro">Rua:</label>
                                <input
                                    type="text"
                                    id="logradouro"
                                    name="logradouro"
                                    placeholder="Digite a rua"
                                    value={logradouro}
                                    required
                                />
                            </div>

                            <div className="form">
                                <label htmlFor="localidade">Cidade:</label>
                                <input
                                    type="text"
                                    id="localidade"
                                    name="localidade"
                                    placeholder="Digite a cidade"
                                    value={localidade}
                                    required
                                />
                            </div>

                            <div className="form">
                                <label htmlFor="bairro">Bairro:</label>
                                <input
                                    type="text"
                                    id="bairro"
                                    name="bairro"
                                    placeholder="Digite o bairro"
                                    value={bairro}
                                    required
                                />
                            </div>

                            <div className="form">
                                <label htmlFor="numero">Numero:</label>
                                <input
                                    type="text"
                                    id="numero"
                                    name="numero"
                                    placeholder="Digite o numero"
                                    value={numero}
                                    onChange={handleNumeroChange}
                                    required
                                />
                            </div>
                        </div>
                    )}
                    <button type='submit'><Link href={"/login"}>Enviar</Link></button>
                </form>
                <p>Caso tenha já tenha uma conta clique <Link href={"/login"}>aqui</Link> para logar-se</p>
            </section>
        </main>
    );
}
