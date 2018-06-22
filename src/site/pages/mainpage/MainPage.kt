package site.pages.mainpage

import components.*
import components.layout.Grid
import components.layout.navigationlayout.MdlContent
import components.layout.navigationlayout.content
import components.layout.grid
import header
import mdlApp
import site.Color
import kotlin.js.Math
import kotlin.math.ceil

object MainPage : MdlContent {

    fun createPage() {
        val mdlApp = mdlApp {
            navigationLayout(MainPage, "layout") {
                header(Color.primary) {
                }
                drawer("drawer") {
                    mainElement.header("drawer-header") {
                        setAttribute("style", " background: url('assets/images/icon.jpg') center / cover; padding: 10px;")
                    }

                    nav("navigation") {
                        link {
                            text = "Foros"
                            materialIcons = "forum"
                            href = "forum.html"
                        }
                        link {
                            text = "Ingresar"
                            materialIcons = "account_circle"
                            onClick {
                                dialog {
                                    title = "Ingresar"
                                    buttonSecondary = Dialog.Button()
                                }
                            }
                        }
                        link {
                            text = "Acerca de"
                            materialIcons = "info"
                            onClick {
                                dialog {
                                    title = "Acerca de"
                                    content = "Emmanuel Messulam"
                                    buttonSecondary = Dialog.Button()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override val content = content("Pagina Principal") {
        grid {
            createX(Array(50) {
                MainPageCard("assets/images/weapons/$it.jpg", "Rithmio",
                        """
                        At Rithmio I Introduced new technologies like
                        Kotlin and RxJava which have helped to make the
                        team faster and more efficient.
                        """)
            })
        }
    }

    private fun Grid.createX(mainPageCards: Array<MainPageCard>) {
        for (mainPageCard in mainPageCards) {
            cellCard(2) {
                size()
                image = Card.Image(mainPageCard.image, cssClassNames = "center-cropped-image")
                title = mainPageCard.title
                supportingText = mainPageCard.supportingText
                button = Card.Button("VER", Color.accent) {
                    dialog {
                        title = "Rithmio"
                        content = "At Rithmio I Introduced new technologies like Kotlin and RxJava which have helped to make the team faster and more efficient."
                        buttonSecondary = Dialog.Button()
                        buttonPrimary = Dialog.Button("Ir a foros", false, "forum.html",
                                color = Color.accent)
                    }
                }
            }
        }
    }

    private data class MainPageCard(val image: String, val title: String, val supportingText: String)
}

