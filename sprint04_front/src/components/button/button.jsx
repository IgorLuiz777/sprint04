
import Link from "next/link"

export default function Button () {

    return(
        <div className="button">
            <Link href={props.href}>{props.children}</Link>
        </div>
    )
}