
import Header from '@/components/header/header'
import Footer from '@/components/footer/footer'
import Logo from '@/components/logo/logo'
import './globals.scss'

export const metadata = {
  title: 'Porto Seguro',
  description: 'Seguros para bikes.',
}

export default function RootLayout({ children }) {
  return (
    <html lang="pt-br">
      
      <body>
        <header>
          <Logo></Logo>
          <Header></Header>
        </header>
        <main>
          {children}
        </main>
        <footer>
          <Footer></Footer>
        </footer>
      </body>
    </html>
  )
}
