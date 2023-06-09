package ingresos.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import ingresos.IntegrationTest;
import ingresos.domain.Usuario;
import ingresos.repository.EntityManager;
import ingresos.repository.UsuarioRepository;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Integration tests for the {@link UsuarioResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class UsuarioResourceIT {

    private static final String DEFAULT_USUARIO = "AAAAAAAAAA";
    private static final String UPDATED_USUARIO = "BBBBBBBBBB";

    private static final String DEFAULT_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_PASSWORD = "BBBBBBBBBB";

    private static final String DEFAULT_CORREO_INSTITUCIONAL = "AAAAAAAAAA";
    private static final String UPDATED_CORREO_INSTITUCIONAL = "BBBBBBBBBB";

    private static final String DEFAULT_ROL = "AAAAAAAAAA";
    private static final String UPDATED_ROL = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/usuarios";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private Usuario usuario;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Usuario createEntity(EntityManager em) {
        Usuario usuario = new Usuario()
            .usuario(DEFAULT_USUARIO)
            .password(DEFAULT_PASSWORD)
            .correoInstitucional(DEFAULT_CORREO_INSTITUCIONAL)
            .rol(DEFAULT_ROL);
        return usuario;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Usuario createUpdatedEntity(EntityManager em) {
        Usuario usuario = new Usuario()
            .usuario(UPDATED_USUARIO)
            .password(UPDATED_PASSWORD)
            .correoInstitucional(UPDATED_CORREO_INSTITUCIONAL)
            .rol(UPDATED_ROL);
        return usuario;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(Usuario.class).block();
        } catch (Exception e) {
            // It can fail, if other entities are still referring this - it will be removed later.
        }
    }

    @AfterEach
    public void cleanup() {
        deleteEntities(em);
    }

    @BeforeEach
    public void setupCsrf() {
        webTestClient = webTestClient.mutateWith(csrf());
    }

    @BeforeEach
    public void initTest() {
        deleteEntities(em);
        usuario = createEntity(em);
    }

    @Test
    void createUsuario() throws Exception {
        int databaseSizeBeforeCreate = usuarioRepository.findAll().collectList().block().size();
        // Create the Usuario
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(usuario))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeCreate + 1);
        Usuario testUsuario = usuarioList.get(usuarioList.size() - 1);
        assertThat(testUsuario.getUsuario()).isEqualTo(DEFAULT_USUARIO);
        assertThat(testUsuario.getPassword()).isEqualTo(DEFAULT_PASSWORD);
        assertThat(testUsuario.getCorreoInstitucional()).isEqualTo(DEFAULT_CORREO_INSTITUCIONAL);
        assertThat(testUsuario.getRol()).isEqualTo(DEFAULT_ROL);
    }

    @Test
    void createUsuarioWithExistingId() throws Exception {
        // Create the Usuario with an existing ID
        usuario.setId(1L);

        int databaseSizeBeforeCreate = usuarioRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(usuario))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllUsuariosAsStream() {
        // Initialize the database
        usuarioRepository.save(usuario).block();

        List<Usuario> usuarioList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(Usuario.class)
            .getResponseBody()
            .filter(usuario::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(usuarioList).isNotNull();
        assertThat(usuarioList).hasSize(1);
        Usuario testUsuario = usuarioList.get(0);
        assertThat(testUsuario.getUsuario()).isEqualTo(DEFAULT_USUARIO);
        assertThat(testUsuario.getPassword()).isEqualTo(DEFAULT_PASSWORD);
        assertThat(testUsuario.getCorreoInstitucional()).isEqualTo(DEFAULT_CORREO_INSTITUCIONAL);
        assertThat(testUsuario.getRol()).isEqualTo(DEFAULT_ROL);
    }

    @Test
    void getAllUsuarios() {
        // Initialize the database
        usuarioRepository.save(usuario).block();

        // Get all the usuarioList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=id,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].id")
            .value(hasItem(usuario.getId().intValue()))
            .jsonPath("$.[*].usuario")
            .value(hasItem(DEFAULT_USUARIO))
            .jsonPath("$.[*].password")
            .value(hasItem(DEFAULT_PASSWORD))
            .jsonPath("$.[*].correoInstitucional")
            .value(hasItem(DEFAULT_CORREO_INSTITUCIONAL))
            .jsonPath("$.[*].rol")
            .value(hasItem(DEFAULT_ROL));
    }

    @Test
    void getUsuario() {
        // Initialize the database
        usuarioRepository.save(usuario).block();

        // Get the usuario
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, usuario.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(usuario.getId().intValue()))
            .jsonPath("$.usuario")
            .value(is(DEFAULT_USUARIO))
            .jsonPath("$.password")
            .value(is(DEFAULT_PASSWORD))
            .jsonPath("$.correoInstitucional")
            .value(is(DEFAULT_CORREO_INSTITUCIONAL))
            .jsonPath("$.rol")
            .value(is(DEFAULT_ROL));
    }

    @Test
    void getNonExistingUsuario() {
        // Get the usuario
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingUsuario() throws Exception {
        // Initialize the database
        usuarioRepository.save(usuario).block();

        int databaseSizeBeforeUpdate = usuarioRepository.findAll().collectList().block().size();

        // Update the usuario
        Usuario updatedUsuario = usuarioRepository.findById(usuario.getId()).block();
        updatedUsuario
            .usuario(UPDATED_USUARIO)
            .password(UPDATED_PASSWORD)
            .correoInstitucional(UPDATED_CORREO_INSTITUCIONAL)
            .rol(UPDATED_ROL);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedUsuario.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedUsuario))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
        Usuario testUsuario = usuarioList.get(usuarioList.size() - 1);
        assertThat(testUsuario.getUsuario()).isEqualTo(UPDATED_USUARIO);
        assertThat(testUsuario.getPassword()).isEqualTo(UPDATED_PASSWORD);
        assertThat(testUsuario.getCorreoInstitucional()).isEqualTo(UPDATED_CORREO_INSTITUCIONAL);
        assertThat(testUsuario.getRol()).isEqualTo(UPDATED_ROL);
    }

    @Test
    void putNonExistingUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().collectList().block().size();
        usuario.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, usuario.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(usuario))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().collectList().block().size();
        usuario.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(usuario))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().collectList().block().size();
        usuario.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(usuario))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateUsuarioWithPatch() throws Exception {
        // Initialize the database
        usuarioRepository.save(usuario).block();

        int databaseSizeBeforeUpdate = usuarioRepository.findAll().collectList().block().size();

        // Update the usuario using partial update
        Usuario partialUpdatedUsuario = new Usuario();
        partialUpdatedUsuario.setId(usuario.getId());

        partialUpdatedUsuario.usuario(UPDATED_USUARIO).password(UPDATED_PASSWORD);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedUsuario.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedUsuario))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
        Usuario testUsuario = usuarioList.get(usuarioList.size() - 1);
        assertThat(testUsuario.getUsuario()).isEqualTo(UPDATED_USUARIO);
        assertThat(testUsuario.getPassword()).isEqualTo(UPDATED_PASSWORD);
        assertThat(testUsuario.getCorreoInstitucional()).isEqualTo(DEFAULT_CORREO_INSTITUCIONAL);
        assertThat(testUsuario.getRol()).isEqualTo(DEFAULT_ROL);
    }

    @Test
    void fullUpdateUsuarioWithPatch() throws Exception {
        // Initialize the database
        usuarioRepository.save(usuario).block();

        int databaseSizeBeforeUpdate = usuarioRepository.findAll().collectList().block().size();

        // Update the usuario using partial update
        Usuario partialUpdatedUsuario = new Usuario();
        partialUpdatedUsuario.setId(usuario.getId());

        partialUpdatedUsuario
            .usuario(UPDATED_USUARIO)
            .password(UPDATED_PASSWORD)
            .correoInstitucional(UPDATED_CORREO_INSTITUCIONAL)
            .rol(UPDATED_ROL);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedUsuario.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedUsuario))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
        Usuario testUsuario = usuarioList.get(usuarioList.size() - 1);
        assertThat(testUsuario.getUsuario()).isEqualTo(UPDATED_USUARIO);
        assertThat(testUsuario.getPassword()).isEqualTo(UPDATED_PASSWORD);
        assertThat(testUsuario.getCorreoInstitucional()).isEqualTo(UPDATED_CORREO_INSTITUCIONAL);
        assertThat(testUsuario.getRol()).isEqualTo(UPDATED_ROL);
    }

    @Test
    void patchNonExistingUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().collectList().block().size();
        usuario.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, usuario.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(usuario))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().collectList().block().size();
        usuario.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(usuario))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().collectList().block().size();
        usuario.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(usuario))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteUsuario() {
        // Initialize the database
        usuarioRepository.save(usuario).block();

        int databaseSizeBeforeDelete = usuarioRepository.findAll().collectList().block().size();

        // Delete the usuario
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, usuario.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<Usuario> usuarioList = usuarioRepository.findAll().collectList().block();
        assertThat(usuarioList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
