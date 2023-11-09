
import './page.scss'

export default function Contato() {

    return(
        <main>
            <section className="formulario">
                <h2 className="contato-titulo1">FORMULÁRIO DE CONTATO</h2>
                <form className="form">
                    <label className="form1" htmlFor="name">Nome</label>
                    <input className="form1" type="text" name="name" id="name"/>
                    <label className="form1" htmlFor="email">E-mail</label>
                    <input className="form1" type="email" name="email" id="email"/>
                    <label className="form1" htmlFor="message">Mensagem</label>
                    <textarea className="form1" name="message" id="message"></textarea>
                    <button type="submit" className="contato-button">Enviar</button>
                </form>
            </section>
        </main>
    )
}