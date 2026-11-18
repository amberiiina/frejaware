package se.frejaware.client.Model;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.LightCoordsUtil;
import net.minecraft.util.RandomSource;

public class FGlaciermanParticle extends SingleQuadParticle {
	private final double xStart;
	private final double yStart;
	private final double zStart;

	protected FGlaciermanParticle(final ClientLevel level, final double x, final double y, final double z, final double xd, final double yd, final double zd, final TextureAtlasSprite sprite) {
		super(level, x, y, z, sprite);
		this.xd = xd;
		this.yd = yd;
		this.zd = zd;
		this.x = x;
		this.y = y;
		this.z = z;
		this.xStart = x;
		this.yStart = y;
		this.zStart = z;
		this.quadSize = 0.1F * (this.random.nextFloat() * 0.2F + 0.5F);
		this.lifetime = (int) (this.random.nextFloat() * 10.0F) + 40;
	}

	@Override
	public SingleQuadParticle.Layer getLayer() {
		return Layer.OPAQUE;
	}

	@Override
	public void move(final double xa, final double ya, final double za) {
		this.setBoundingBox(this.getBoundingBox().move(xa, ya, za));
		this.setLocationFromBoundingbox();
	}

	@Override
	public float getQuadSize(final float a) {
		float s = ((float) this.age + a) / (float) this.lifetime;
		s = 1.0F - s;
		s *= s;
		s = 1.0F - s;
		return this.quadSize * s;
	}

	@Override
	public int getLightCoords(final float a) {
		float brightness = (float) this.age / (float) this.lifetime;
		brightness *= brightness;
		brightness *= brightness;
		return LightCoordsUtil.addSmoothBlockEmission(super.getLightCoords(a), brightness);
	}

	@Override
	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		if (this.age++ >= this.lifetime) {
			this.remove();
		} else {
			float pos = (float) this.age / (float) this.lifetime;
			float a = pos;
			pos = -pos + pos * pos * 2.0F;
			pos = 1.0F - pos;
			this.x = this.xStart + this.xd * (double) pos;
			this.y = this.yStart + this.yd * (double) pos + (double) (1.0F - a);
			this.z = this.zStart + this.zd * (double) pos;
		}
	}

	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;

		public Provider(final SpriteSet sprite) {
			this.sprite = sprite;
		}

		@Override
		public Particle createParticle(final SimpleParticleType options, final ClientLevel level,
									   final double x, final double y, final double z,
									   final double xAux, final double yAux, final double zAux,
									   final RandomSource random) {
			return new FGlaciermanParticle(level, x, y, z, xAux, yAux, zAux, this.sprite.get(random));
		}
	}
}