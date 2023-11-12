
import Button from "@/components/button/button"
import './home.scss'
import Planos from "../components/planos/planos"

export default function Home() {
  return(
    <main>
        <section className="part1">
            <div className="div1">  
                <h1 className="titulo1">Não corra riscos com a segurança da sua bicicleta. Proteja seu patrimônio com nosso seguro completo para bicicletas.</h1>
                <p className="texto1">Faça agora mesmo o cadastramento de sua bicicleta clicando no botão abaixo:</p>
                <Button href="/cadastro">Cadastre-se agora</Button>
            </div>
                
            <div className="divimg">
                <img id="img1" src="bike2.webp" alt="Bike"/>
            </div>
            
                
        </section>
        <section className="planos">
            <Planos></Planos>
        </section>
            
    </main>
)
}
