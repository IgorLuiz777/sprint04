
import Link from "next/link"
import './button.scss'

export default function Button (props) {

    return(
        <div className="button">
            <Link href={props.href}>{props.children}</Link>
        </div>
    )
}