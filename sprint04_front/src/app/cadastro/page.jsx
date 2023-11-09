
import './page.scss'

export default function Cadastro() {

    return(
        <main>
            <section className="content">
                <h2>Insira os seus dados para criar seu cadastro: </h2>
                <form>

                    <div className="form">
                        <label htmlFor="nome">Nome:</label>
                        <input type="text" id="nome" name="nome" placeholder="Digite seu nome" required/>
                    </div>
                    
                    <div className="form">
                        <label htmlFor="data_nasc">Data de nascimento:</label>
                        <input type="date" id="data_nasc" name="data_nasc" placeholder="Digite sua data de nascimento" required/>
                    </div>

                    <div className="form">
                        <label htmlFor="cpf">CPF:</label>
                        <input type="text" name="cpf"
                            placeholder='Digite seu CPF'
			                pattern="\d{3}\.\d{3}\.\d{3}-\d{2}"
			                title="Digite um CPF no formato: xxx.xxx.xxx-xx"/>
		                <input type="submit" value="Verificar" required/>
                    </div>

                    <div className="form">
                        <label htmlFor="telefone">Telefone:</label>
                        <input 
                            pattern="\d{11}"
                            title="Digite o número no formato: xxxxxxxxxxx" type="tel" id="telefone" name="telefone" placeholder="Digite seu telefone" required/>
                        <input type="submit" value="Verificar" required/>
                    </div>

                    <div className="form">
                        <label htmlFor="email">E-mail:</label>
                        <input type="email" id="email" name="email" placeholder="Digite seu email" required/>
                    </div>

                    <div className="form">
                        <label htmlFor="senha">Senha:</label>
                        <input type="password" id="senha" name="senha" placeholder="Digite sua senha" required/>
                    </div>

                    <div className="form">
                        <label htmlFor="cep">CEP:</label>
                        <input type="cep" id="cep" name="cep" placeholder="Digite o seu cep" required/>
                    </div>

                    <div className="form">
                        <label htmlFor="logradouro">Rua:</label>
                        <input type="text" id="logradouro" name="logradouro" placeholder="Digite o número de série" required/>
                    </div>

                    <div className="form">
                        <label htmlFor="numero">Número:</label>
                        <input type="number" id="numero" name="numero" placeholder="Digite o número" required/>
                    </div>

                    <button type="submit" className="login-button">Enviar</button>
                </form>
            </section>
        </main>
    )
}