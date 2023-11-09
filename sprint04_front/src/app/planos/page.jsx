
import './page.scss'

export default function Planos() {

    return (
        <main>
            <section className="content-planos">
                <div className="flex-item-standard">
                    <h2 className='standard'>Standard</h2>
                    <ul>
                        <li>Furto e Roubo</li>
                        <li>Cobertura regional</li>
                    </ul>
                    <button type="submit" className="plano-standard">Adicionar plano</button>
                </div>
                <div className="flex-item-plus">
                    <h2 className='plus'>&nbsp;&nbsp;&nbsp;&nbsp;Plus&nbsp;&nbsp;&nbsp;&nbsp;</h2>
                    <ul>
                        <li>Furto e roubo</li>
                        <li>Danos</li>
                        <li>Cobertura nacional</li>
                    </ul>
                    <button type="submit" className="plano-plus">Adicionar plano</button>
                </div>
                <div className="flex-item-premium">
                    <h2 className='premium'>Premium</h2>
                    <ul>
                        <li>Furto e roubo</li>
                        <li>Danos</li>
                        <li>Perda total</li>
                        <li>Cobertura mundial</li>
                    </ul>
                    <button type="submit" className="plano-premium">Adicionar plano</button>
                </div>
            </section>
        </main>
    )
}